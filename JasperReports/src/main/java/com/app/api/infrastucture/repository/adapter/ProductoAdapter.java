package com.app.api.infrastucture.repository.adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.app.api.domain.model.Producto;
import com.app.api.domain.services.ProductoService;
import com.app.api.exceptions.RegistroNoEncontradoException;
import com.app.api.infrastucture.dto.ProductoDto;
import com.app.api.infrastucture.mapper.ProductoMapper;
import com.app.api.infrastucture.repository.database.ProductoRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductoAdapter implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	ProductoMapper productoMapper;

	@Override
	public List<Producto> buscarPorIds(List<String> codigos) {
		return productoRepository.findAllById(codigos.stream().map(codigo -> codigo).collect(Collectors.toList()))
				.stream().map(producto -> productoMapper.transformarDtoParaDominio(producto))
				.collect(Collectors.toList());
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(productoMapper.transformarDominioParaDto(producto));
	}

	@Override
	public void editar(Producto producto) {
		this.buscarPorId(producto.getId().getValue());
		productoRepository.save(productoMapper.transformarDominioParaDto(producto));
	}

	@Override
	public Producto buscarPorId(String id) {
		return productoMapper.transformarDtoParaDominio(
				productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoException()));
	}

	@Override
	public List<Producto> buscarTodos() {
		return productoRepository.findAll().stream().map(producto -> productoMapper.transformarDtoParaDominio(producto))
				.collect(Collectors.toList());
	}

	@Override
	public void eliminarPorId(String id) {
		ProductoDto producto = productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoException());
		productoRepository.deleteById(producto.getId());
	}

	@Override
	public String exportGeneralReport() throws FileNotFoundException, JRException {

		boolean status = saveThePdf(productoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
		if (status) {
			return "report has been generated";
		} else {
			return "Oops, got a problem...";
		}
	}

	@Override
	public String exportListReport(List<String> codigos) throws FileNotFoundException, JRException {

		boolean status = saveThePdf(productoRepository.findProductosByIdList(codigos));
		if (status) {
			return "report has been generated";
		} else {
			return "Oops, got a problem...";
		}
	}

	private Boolean saveThePdf(List<ProductoDto> list) throws FileNotFoundException, JRException {
		String path = "src\\main\\resources\\static";

		File file = ResourceUtils.getFile("src\\main\\resources\\products_report.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

		Map<String, Object> parameter = new HashMap<>();
		parameter.put("createdBy", "Jhooomn");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\report.pdf");
		return true;
	}

}
