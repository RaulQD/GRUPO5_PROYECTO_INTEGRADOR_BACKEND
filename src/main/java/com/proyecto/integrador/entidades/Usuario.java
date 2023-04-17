package com.proyecto.integrador.entidades;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String apellidoPa;
	private String apellidoMa;
	private String telefono;
	private String correo;
	private String username;
	private String password;
	private String foto;
	private int idTipoUsu;
	private int idCuentaBancaria;
	private Date fecha;
	private int idHisInver;
	private int dni;
	private int ruc;
	private String razonSocial;
	private String descripcion;
	private int idSubasta;
	private boolean enable = true;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
	@JsonIgnore
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();

	
	
	
	public Usuario() {
		super();
	}

	public Usuario(long id, String nombre, String apellidoPa, String apellidoMa, String telefono, String correo,
			String username, String password, String foto, int idTipoUsu, int idCuentaBancaria, Date fecha,
			int idHisInver, int dni, int ruc, String razonSocial, String descripcion, int idSubasta, boolean enable,
			Set<UsuarioRol> usuarioRoles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPa = apellidoPa;
		this.apellidoMa = apellidoMa;
		this.telefono = telefono;
		this.correo = correo;
		this.username = username;
		this.password = password;
		this.foto = foto;
		this.idTipoUsu = idTipoUsu;
		this.idCuentaBancaria = idCuentaBancaria;
		this.fecha = fecha;
		this.idHisInver = idHisInver;
		this.dni = dni;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.descripcion = descripcion;
		this.idSubasta = idSubasta;
		this.enable = enable;
		this.usuarioRoles = usuarioRoles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPa() {
		return apellidoPa;
	}

	public void setApellidoPa(String apellidoPa) {
		this.apellidoPa = apellidoPa;
	}

	public String getApellidoMa() {
		return apellidoMa;
	}

	public void setApellidoMa(String apellidoMa) {
		this.apellidoMa = apellidoMa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdTipoUsu() {
		return idTipoUsu;
	}

	public void setIdTipoUsu(int idTipoUsu) {
		this.idTipoUsu = idTipoUsu;
	}

	public int getIdCuentaBancaria() {
		return idCuentaBancaria;
	}

	public void setIdCuentaBancaria(int idCuentaBancaria) {
		this.idCuentaBancaria = idCuentaBancaria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdHisInver() {
		return idHisInver;
	}

	public void setIdHisInver(int idHisInver) {
		this.idHisInver = idHisInver;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> autoridades = new HashSet<>();
		this.usuarioRoles.forEach(usuarioRol -> {
			autoridades.add(new Authority(usuarioRol.getRol().getTipo()));
		});
		return autoridades;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

	
}