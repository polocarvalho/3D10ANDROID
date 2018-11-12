package e.polo.smartmitton.activities



interface businessManagerInterface {

    fun  getBasket() : Basket
    fun addIngredient (ingredient: Ingredient)
    fun getBasketSize() : Int

    fun getRecipes (ingredients: ArrayList<Ingredient>): List<String>
    fun getRecipes (recipesCallBack : RecipesCallBack)



}