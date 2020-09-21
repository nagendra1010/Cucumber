$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/search.feature");
formatter.feature({
  "name": "Search and place order for vegetable",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Search for items and move to checkout page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "name": "User is on Greencart landing page",
  "keyword": "Given "
});
formatter.step({
  "name": "User search for \u003cName\u003e Vegetable",
  "keyword": "When "
});
formatter.step({
  "name": "added items to cart",
  "keyword": "And "
});
formatter.step({
  "name": "user proceeded to Checkout page for purchase",
  "keyword": "And "
});
formatter.step({
  "name": "verify selected \u003cName\u003e items are dispalyed in checkout page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Name"
      ]
    },
    {
      "cells": [
        "Brinjal"
      ]
    },
    {
      "cells": [
        "Beetroot"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search for items and move to checkout page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "name": "User is on Greencart landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.user_is_on_greencart_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User search for Brinjal Vegetable",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.user_search_for_something_vegetable(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "added items to cart",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.added_items_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user proceeded to Checkout page for purchase",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.user_proceeded_to_checkout_page_for_purchase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify selected Brinjal items are dispalyed in checkout page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.verify_selected_something_items_are_dispalyed_in_checkout_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Search for items and move to checkout page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "name": "User is on Greencart landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.user_is_on_greencart_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User search for Beetroot Vegetable",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.user_search_for_something_vegetable(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "added items to cart",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.added_items_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user proceeded to Checkout page for purchase",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.user_proceeded_to_checkout_page_for_purchase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify selected Beetroot items are dispalyed in checkout page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.myStepDefination.verify_selected_something_items_are_dispalyed_in_checkout_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});