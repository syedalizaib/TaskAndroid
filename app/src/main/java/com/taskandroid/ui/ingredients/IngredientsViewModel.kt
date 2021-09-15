package com.taskandroid.ui.ingredients

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taskandroid.entities.Ingeredient

class IngredientsViewModel() : ViewModel() {

    val ingredientList: MutableLiveData<ArrayList<Ingeredient>> = MutableLiveData()


    fun createBentoIngredientsData() {
        ingredientList.value = arrayListOf(
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 12,
                available = true,
                image = "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTd8fHxlbnwwfHx8fA%3D%3D&w=1000&q=80"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 13,
                available = false,
                image = "https://img.freepik.com/free-photo/top-view-tray-with-delicious-food_23-2148723446.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 12,
                available = false,
                image = "https://img.freepik.com/free-photo/delicious-vietnamese-food-including-pho-ga-noodles-spring-rolls-white-table_181624-34062.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 13,
                available = true,
                image = "https://post.healthline.com/wp-content/uploads/2020/07/pizza-beer-1200x628-facebook-1200x628.jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 12,
                available = false,
                image = "https://img.freepik.com/free-photo/top-view-fast-food-mix-hamburger-doner-sandwich-chicken-nuggets-rice-vegetable-salad-chicken-sticks-caesar-salad-mushrooms-pizza-chicken-ragout-french-fries-mayo_141793-3997.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 13,
                available = true,
                image = "https://www.diana-food.com/fileadmin/diana_food/5_Landing_pages/Culinary_Creations/Diana_Food_Culinary_Creations_3col_424x424.jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 52,
                available = true,
                image = "https://img.freepik.com/free-photo/delicious-vietnamese-food-including-pho-ga-noodles-spring-rolls-white-table_181624-34062.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 9,
                available = true,
                image = "https://post.healthline.com/wp-content/uploads/2020/07/pizza-beer-1200x628-facebook-1200x628.jpg"
            )
        )
    }

    fun createMainIngredientsData() {
        ingredientList.value = arrayListOf(
            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 12,
                available = false,
                image = "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTd8fHxlbnwwfHx8fA%3D%3D&w=1000&q=80"
            ),

            Ingeredient(
                id = 1,
                title = "Biryani large fried rice + Noodles",
                quantity = 13,
                available = true,
                image = "https://post.healthline.com/wp-content/uploads/2020/07/pizza-beer-1200x628-facebook-1200x628.jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Pizza + Noodles",
                quantity = 13,
                available = true,
                image = "https://img.freepik.com/free-photo/top-view-tray-with-delicious-food_23-2148723446.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special Sandwich + Noodles",
                quantity = 22,
                available = true,
                image = "https://img.freepik.com/free-photo/delicious-vietnamese-food-including-pho-ga-noodles-spring-rolls-white-table_181624-34062.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "BBQ + Noodles",
                quantity = 12,
                available = false,
                image = "https://img.freepik.com/free-photo/top-view-fast-food-mix-hamburger-doner-sandwich-chicken-nuggets-rice-vegetable-salad-chicken-sticks-caesar-salad-mushrooms-pizza-chicken-ragout-french-fries-mayo_141793-3997.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special fried rice + Noodles",
                quantity = 15,
                available = true,
                image = "https://www.diana-food.com/fileadmin/diana_food/5_Landing_pages/Culinary_Creations/Diana_Food_Culinary_Creations_3col_424x424.jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special extra fried rice + Noodles",
                quantity = 19,
                available = true,
                image = "https://post.healthline.com/wp-content/uploads/2020/07/pizza-beer-1200x628-facebook-1200x628.jpg"
            )
        )
    }

    fun createAppetizerIngredientsData() {
        ingredientList.value = arrayListOf(


            Ingeredient(
                id = 1,
                title = "Special extra large fried rice + Noodles",
                quantity = 13,
                available = true,
                image = "https://post.healthline.com/wp-content/uploads/2020/07/pizza-beer-1200x628-facebook-1200x628.jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Special Pizza + Noodles",
                quantity = 13,
                available = false,
                image = "https://img.freepik.com/free-photo/top-view-tray-with-delicious-food_23-2148723446.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Biryani rice + Noodles",
                quantity = 22,
                available = false,
                image = "https://img.freepik.com/free-photo/delicious-vietnamese-food-including-pho-ga-noodles-spring-rolls-white-table_181624-34062.jpg?size=626&ext=jpg"
            ),
            Ingeredient(
                id = 1,
                title = "Extra large fried rice + Noodles",
                quantity = 12,
                available = false,
                image = "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTd8fHxlbnwwfHx8fA%3D%3D&w=1000&q=80"
            ),
            Ingeredient(
                id = 1,
                title = "Chicken Tikka",
                quantity = 12,
                available = true,
                image = "https://img.freepik.com/free-photo/top-view-fast-food-mix-hamburger-doner-sandwich-chicken-nuggets-rice-vegetable-salad-chicken-sticks-caesar-salad-mushrooms-pizza-chicken-ragout-french-fries-mayo_141793-3997.jpg?size=626&ext=jpg"
            )
        )
    }
}