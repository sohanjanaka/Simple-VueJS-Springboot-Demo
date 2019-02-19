<template>
  <div>
    <div class="row">
      <div class="container">
        <center>
          <div class="jumbotron" style="padding: 20px">
            <div class="row">
              <div class="col-md-2"></div>
              <div class="col-md-8">
                <h2>
                  <b>Price List</b>
                </h2>
              </div>
              <div class="col-md-2"></div>
            </div>
          </div>
        </center>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-md-2"></div>
      <div class="col-md-8">
        <div class="col-md-5">
          <router-link to="/calculator">
            <button type="button" class="btn btn-success">Calculator</button>
          </router-link>
        </div>
        <div class="col-md-5"></div>
        <div class="col-md-2"></div>
      </div>
      <div class="col-md-2"></div>
    </div>

    <br>
    <div class="col-md-2"></div>
    <div class="col-md-8">
      <product-table></product-table>
    </div>
    <div class="col-md-2"></div>
  </div>
</template>

<script>
import ProductTable from "./product_table.vue";

export default {
  name: "PriceList",
  components: {
    ProductTable
  }
};
</script>

<style>
</style>
