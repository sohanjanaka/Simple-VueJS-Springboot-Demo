<template>
  <table class="table table-bordered table-responsive">
    <thead>
      <tr class="success">
        <th class="col-md-1">Product ID</th>
        <th class="col-md-3">Product Name</th>
        <th class="col-md-2">Price (Rs.)</th>
      </tr>
    </thead>
    <tbody id="TrRow">
      <tr v-for="product in products">
        <td>{{ product.id }}</td>
        <td>{{ product.name }}</td>
        <td>{{ product.price }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "ProdctTable",
  mounted() {
    this.getProducts();
    console.log("mounted: got here");
  },
  data() {
    return {
      products: []
    };
  },
  methods: {
    getProducts() {
      const self = this;
      const url = "http://localhost:8080/products/";
      axios
        .get(url, {
          dataType: "json",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json"
          },
          mode: "no-cors",
          credentials: "include"
        })
        .then(response => {
          console.log(JSON.stringify(response.data));
          self.products = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>

<style>
</style>
