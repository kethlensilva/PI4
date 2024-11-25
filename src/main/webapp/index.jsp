<html>
<body>
<h2>Lar & Aconchego</h2>

<form action="/create-lar" method="post">

    <label>usuario</label>
    <input type="text" name="lar-name" id="lar-name" value="${param.name}">
    <input type="hidden" id="id" name="id" value="${param.id}">

    <button type="submit">Save</button>

</form>

</body>
</html>