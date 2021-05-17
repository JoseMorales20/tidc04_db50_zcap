<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
		  <form  method="POST" action="AgregarJuegoController.do">
			<div class="card">
				<div class="card-header has-background-warning">
					<span class="card-header-title is-centered">Agregar juego</span>
				</div>
				<div class="card-content">
					<div class="field">
						<label for="nombre-txt" class="label">Nombre</label>
						<div class="control">
							<input type="text" class="input" id="nombre-txt" name="nombre-txt" />
						</div>
					</div>
					<div class="field">
						<label for="descripccion-txt" class="label">Descripcion</label>
						<div class="control">
							<textarea class="textarea" id="descripcion-txt" name="descripcion-txt"></textarea>
						</div>
					</div>
					<div class="field">
						<label for="consola-select" class="label">Consola</label>
						<div class="control">
							<div class="select">
								<select id="consola-select" name="consola-select"></select>
							</div>
						</div>
					</div>
					<div class="field">
						<label class="label" for="aptop-radio">¿Apto para niños?</label>
						<div class="control">
							<label class="radio">
								<input type="radio" name="apto-radio" value="si" />Si
							</label>
							<label class="radio">
								<input type="radio" name="apto-radio" value="no" />No	
							</label>
						</div>
					</div>
					<div class="field">
						<label class="label" for="precio-txt">Precio</label>
						<div class="control">
							<input type="number" id="precio-txt" class="input" name="precio-txt" />
						</div>
					</div>
					<div class="field">
						<label class="label" for="fecha-txt">Fecha de lanzamiento</label>
						<div class="control">
							<input type="date" class="input" id="fecha-txt" name="fecha-txt" />
						</div>
					</div>
				</div>
				<div class="card-footer">
					<div class="card-footer-item has-text-centered">
						<button type="submit" class="button is-info">Registrar</button>
					</div>
				</div>
			</div>
		  </form>
		</div>
	</div>
</main>
</body>
</html>