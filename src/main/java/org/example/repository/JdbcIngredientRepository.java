package org.example.repository;

/*
@Repository
public class JdbcIngredientRepository implements IngridientRepositry{
    private JdbcTemplate jdbc;
    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Iterable<Ingredients> findAll() {
        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }
    @Override
    public Ingredients findById(String id) {
        return jdbc.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
    }
    private Ingredients mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredients(
                rs.getString("id"),
                rs.getString("name"),
                Ingredients.Type.valueOf(rs.getString("type")));
    }
    @Override
    public Ingredients save(Ingredients ingredient) {
        jdbc.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
*/
