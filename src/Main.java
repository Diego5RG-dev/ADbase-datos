//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    CRUD.insertarAnime(new Anime("One Piece2", "El mejor anime de piratas", java.sql.Date.valueOf("1997-7-22"), 10));
    CRUD.leerTodosAnimes();
    CRUD.UpdateAnime(new Anime("One Piece", "El mejor anime escrito del mundo, va sobre piratas", java.sql.Date.valueOf("1997-7-22"), 100),
    "One Piece2");
    CRUD.LeerAnimeFiltrado("One Piece");
    CRUD.EliminarAnime("One Piece");
    CRUD.leerTodosAnimes();


}



