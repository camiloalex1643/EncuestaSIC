<jsp:include page="Header.jsp" />

<form action="Home" method="POST">
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" id="login" name="login" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Entrar</button>
</form>

<jsp:include page="Footer.jsp" />