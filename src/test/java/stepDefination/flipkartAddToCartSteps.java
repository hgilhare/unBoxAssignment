package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFile.flipkartAddToCartPage;

public class flipkartAddToCartSteps {
    flipkartAddToCartPage f= new flipkartAddToCartPage();
    @Given("user open flipkart webpage")
    public void user_open_flipkart_webpage() {
        f.useropenflipkartwebpage();
    }
    @When("user click on global search")
    public void user_click_on_global_search() {
        f.userClickOnGlobalSearch();
    }
    @Then("user search with the keyword mobile")
    public void user_search_with_the_keyword_mobile() {
        f.userSearchWithTheKeywordMobile();
    }
    @And("user verify search result for mobile")
    public void user_verify_search_result_for_mobile() {
        f.userVerifySearchResultForMobile();
    }
    @And("user clicks compare checkbox for tenth and eleventh mobile")
    public void user_clicks_compare_checkbox_for_tenth_and_eleventh_mobile() {
        f.userClicksCompareCheckboxForTenthAndEleventhMobile();
    }
    @And("user verify item is added to compare tray")
    public void user_verify_item_is_added_to_compare_tray() {
        f.userVerifyItemIsAddedToCompareTray();
    }
    @And("user clicks and opened tenth phone")
    public void user_clicks_and_opened_tenth_phone() {
        f.userClicksAndOpenedTenthPhone();
    }
    @And("user clicks on add to cart button and verify going to cart text visibility")
    public void user_clicks_on_add_to_cart_button_and_verify_going_to_cart_text_visibility() {
        f.userClicksOnAddToCartButton();
    }
    @And("user verify item is added to cart")
    public void user_verify_item_is_added_to_cart() {
        f.userVerifyItemIsAddedToCart();
    }
    @And("user verify total amount is same")
    public void user_verify_total_amount_is_same() {
        f.userVerifyTotalAmountIsSame();
    }
    @And("user increase product qty by one and verify pop up message displayed")
    public void user_increase_product_qty_by_one_and_verify_pop_up_message_displayed() {
        f.userIncreaseProductQtyByOneAndVerifyPopUpMessageDisplayed();
    }
    @And("user removed product and verified empty screen")
    public void user_removed_product_and_verified_empty_screen() {
        f.userRemoveProductAndVerifyEmptyScreen();
    }
}
