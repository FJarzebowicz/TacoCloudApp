package org.example.repository;

/*
@Repository
public class JdbcTacoRepository implements TacoRepository {
    private final JdbcTemplate jdbc;
    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Taco save(Taco taco){
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (String ingredientId : taco.getIngredients()) {
            saveIngredientToTaco(ingredientId, tacoId);
        }
        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        );
        pscFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        new Timestamp(taco.getCreatedAt().getTime())
                )
        );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(String ingredientId, long tacoId) {
        jdbc.update(
                "insert into Taco_Ingredients (taco, ingredient) values (?, ?)",
                tacoId, ingredientId
        );
    }
}
*/
