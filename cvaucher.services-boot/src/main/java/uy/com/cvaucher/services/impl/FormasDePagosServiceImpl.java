package uy.com.cvaucher.services.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.clases.DescCuentaFormaDePago;
import uy.com.cvaucher.services.clases.FormasDePagosDesc;
import uy.com.cvaucher.services.clases.MaxNumAsientoContable;
import uy.com.cvaucher.services.clases.SearchMaxTratPacId;
import uy.com.cvaucher.services.domain.AsientoContable;
import uy.com.cvaucher.services.domain.Caja;
import uy.com.cvaucher.services.domain.Cuentas;
import uy.com.cvaucher.services.domain.FormasDePagos;
import uy.com.cvaucher.services.domain.HistorialPagos;
import uy.com.cvaucher.services.domain.MaxTratPacId;
import uy.com.cvaucher.services.domain.PagoEfectivo;
import uy.com.cvaucher.services.domain.PagoCredito;
import uy.com.cvaucher.services.domain.PagoTarjeta;
import uy.com.cvaucher.services.domain.Tratamiento;
import uy.com.cvaucher.services.domain.TratamientoPaciente;
import uy.com.cvaucher.services.mybatis.mappers.CajaMapper;
import uy.com.cvaucher.services.mybatis.mappers.FormasDePagosMapper;
import uy.com.cvaucher.services.mybatis.mappers.HistorialPagosMapper;
import uy.com.cvaucher.services.mybatis.mappers.PagoEfectivoMapper;
import uy.com.cvaucher.services.mybatis.mappers.PagoTarjetaMapper;
import uy.com.cvaucher.services.mybatis.mappers.TratamientoPacienteMapper;
import uy.com.cvaucher.services.services.FormasDePagosService;


@Service("formasDePagosService")
@Transactional
public class FormasDePagosServiceImpl implements FormasDePagosService 
{
	@Autowired
	private FormasDePagosMapper 	  formasDePagosMapper;
	
	@Autowired
	private TratamientoPacienteMapper tratamientoPacienteMapper;
	
	@Autowired
	private PagoTarjetaMapper 		  pagoTarjetaMapper;
	
	@Autowired 
	private PagoEfectivoMapper 		  pagoEfectivoMapper;
	
	@Autowired
	private HistorialPagosMapper 	  historialPagosMapper;
	
	@Autowired
	private CajaMapper		   		  cajaMapper;

	@Override
	public List<FormasDePagos> findAllFormasDePagos(FormasDePagos formasDePagos) 
	{
		return this.formasDePagosMapper.findAllFormasDePagos(formasDePagos);
	}

	

	@Override
	public void insertFormasDePagos(FormasDePagos formasDePagos) 
	{
		this.formasDePagosMapper.insertFormasDePagos(formasDePagos);
	}

	@Override
	public void updateFormasDePagos(FormasDePagos formasDePagos) 
	{
		this.formasDePagosMapper.updateFormasDePagos(formasDePagos);
	}

	

	@Override
	@Transactional
	public void insertTratamientoPagoTarjeta(TratamientoPaciente tratamientoPaciente, PagoTarjeta pagoTarjeta, int idCuenta) 
	{
		this.tratamientoPacienteMapper.insertTratamientoPacienteMapper(tratamientoPaciente);
		MaxTratPacId maxTratPacId = new MaxTratPacId();
		SearchMaxTratPacId search = new SearchMaxTratPacId();
		search.setCedula(tratamientoPaciente.getPacientes().getCedula());
		search.setFecha(tratamientoPaciente.getFecha());
		search.setTratId(tratamientoPaciente.getTratamId());
		HistorialPagos historialPagos = new HistorialPagos();
		
		int maxId = this.tratamientoPacienteMapper.findMaxTratPacId(search).getMaxId();
		maxTratPacId.setMaxId(maxId);
		Caja caja = this.cajaMapper.cargoCajaActual();
		historialPagos.setHistPagosCajaId(caja.getCajaId());
		historialPagos.setHistTratPacId(maxTratPacId.getMaxId());
		historialPagos.setHistPagosFechaPago(tratamientoPaciente.getFecha());
		historialPagos.setHistPagosMonto(tratamientoPaciente.getCostoTratSesion());
		
		pagoTarjeta.setTarjPagoId(maxTratPacId.getMaxId());
		this.pagoTarjetaMapper.insertPagoTarjeta(pagoTarjeta);
		historialPagos.setHistPagosTipo(pagoTarjeta.getTarjDesc());
		this.historialPagosMapper.insertHistorialPago(historialPagos);
		
		tratamientoPaciente.setTratPacId(maxTratPacId.getMaxId());
		tratamientoPaciente.setImportePagado(historialPagos.getHistPagosMonto());
		this.tratamientoPacienteMapper.updateTratamientoPacienteImporte(tratamientoPaciente);
	}
	
	@Override
	@Transactional
	public void insertTratamientoPagoEfectivo(TratamientoPaciente tratamientoPaciente, PagoEfectivo pago, int idCuenta)
	{
		/*System.out.println("Inicio de CvaucherJni");
		CvaucherJni cvaucher = new CvaucherJni();
		int a = 10;
		int b = 30;
		int c = cvaucher.holaMundo(a, b);
		System.out.println("Desde Java, La suma de " +a+ " + " +b+ " = "+c);
		*/
		
		this.tratamientoPacienteMapper.insertTratamientoPacienteMapper(tratamientoPaciente);
		MaxTratPacId maxTratPacId = new MaxTratPacId();
		SearchMaxTratPacId search = new SearchMaxTratPacId();
		search.setCedula(tratamientoPaciente.getPacientes().getCedula());
		search.setFecha(tratamientoPaciente.getFecha());
		search.setTratId(tratamientoPaciente.getTratamId());
		HistorialPagos historialPagos = new HistorialPagos();
		this.formasDePagosMapper.findAllFormasDePagos(null);
		
		int maxId = this.tratamientoPacienteMapper.findMaxTratPacId(search).getMaxId();
		maxTratPacId.setMaxId(maxId);
		Caja caja = this.cajaMapper.cargoCajaActual();
		historialPagos.setHistPagosCajaId(caja.getCajaId());
		historialPagos.setHistTratPacId(maxTratPacId.getMaxId());
		historialPagos.setHistPagosFechaPago(tratamientoPaciente.getFecha());
		historialPagos.setHistPagosMonto(tratamientoPaciente.getCostoTratSesion());
		
		pago.setPagoEfId(maxTratPacId.getMaxId());
		this.pagoEfectivoMapper.insertPagoEfectivo(pago);
		historialPagos.setHistPagosTipo(pago.getPagoEfDesc());
		this.historialPagosMapper.insertHistorialPago(historialPagos);
		
		tratamientoPaciente.setTratPacId(maxTratPacId.getMaxId());
		tratamientoPaciente.setImportePagado(historialPagos.getHistPagosMonto());
		this.tratamientoPacienteMapper.updateTratamientoPacienteImporte(tratamientoPaciente);
	}
	@Override
	@Transactional
	public void insertTratamientoPagoCredito(TratamientoPaciente tratamientoPaciente, PagoCredito pago, int idCuenta)
	{
		if(tratamientoPaciente !=null) {
			tratamientoPaciente.setImportePagado(pago.getPagoCredImporte());
			
			this.tratamientoPacienteMapper.insertTratamientoPacienteMapper(tratamientoPaciente);
			MaxTratPacId maxTratPacId = new MaxTratPacId();
			SearchMaxTratPacId search = new SearchMaxTratPacId();
			search.setCedula(tratamientoPaciente.getPacientes().getCedula());
			search.setFecha(tratamientoPaciente.getFecha());
			search.setTratId(tratamientoPaciente.getTratamId());
			HistorialPagos historialPagos = new HistorialPagos();
			
			int maxId = this.tratamientoPacienteMapper.findMaxTratPacId(search).getMaxId();
			maxTratPacId.setMaxId(maxId);
			Caja caja = this.cajaMapper.cargoCajaActual();
			historialPagos.setHistPagosCajaId(caja.getCajaId());
			historialPagos.setHistTratPacId(maxTratPacId.getMaxId());
			historialPagos.setHistPagosFechaPago(tratamientoPaciente.getFecha());
			historialPagos.setHistPagosMonto(tratamientoPaciente.getImportePagado());
			
			pago.setPagoCredId(maxTratPacId.getMaxId());
			this.pagoEfectivoMapper.insertPagoEfectivo(pago);
			historialPagos.setHistPagosTipo(pago.getPagoCredDesc());
			this.historialPagosMapper.insertHistorialPago(historialPagos);
			
			tratamientoPaciente.setTratPacId(maxTratPacId.getMaxId());
			int costoTratSesion = tratamientoPaciente.getCostoTratSesion();
			int importePagado = tratamientoPaciente.getImportePagado();
			int saldoPendiente = costoTratSesion - importePagado;
			tratamientoPaciente.setSaldoPendiente(saldoPendiente);
			tratamientoPaciente.setImportePagado(0);
			
			this.tratamientoPacienteMapper.updateTratamientoPacienteImporteCredito(tratamientoPaciente);
		}
		
	}



	@Override
	public FormasDePagosDesc findFormPagoTipoByDesc(String formPagAbreviacion) {
		// TODO Auto-generated method stub
		System.out.println("formPagAbreviacion == "+formPagAbreviacion);
		FormasDePagosDesc d = this.formasDePagosMapper.findFormPagoTipoByDesc(formPagAbreviacion);
		System.out.println("d == "+d.getFormasDePagoTipo());
		return this.formasDePagosMapper.findFormPagoTipoByDesc(formPagAbreviacion);
	}



	@Override
	public DescCuentaFormaDePago cuentaFormaDePagoDesc(int cuentaId){
		
		return this.formasDePagosMapper.cuentaFormaDePagoDesc(cuentaId);
	}
	
	
}
