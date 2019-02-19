<template>
  <div>
    <div class="row">
      <div class="container">
        <center>
          <div class="jumbotron" style="padding: 20px">
            <div class="row">
              <div class="col-md-2">
                <router-link to="/">
                  <img src="../data/images/Home-PNG-04.png" height="60">
                </router-link>
              </div>
              <div class="col-md-8">
                <h2>
                  <b>Calculator</b>
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
        <div id="product">
          <div class="col-md-2">Product ID :</div>
          <div class="col-md-1">{{selectedType}}</div>
          <div class="col-md-4">
            Product Name :
            <select v-model="selectedType" v-on:click="getProductName">
              <option v-for="item in products" :value="item.id">{{ item.name }}</option>
            </select>
          </div>
          <div class="col-md-1">Qty :</div>
          <div class="col-md-2">
            <input type="number" min="0" step="1" v-model="prodQty">
          </div>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-1">
          <button type="button" class="btn btn-success" id="addTable" v-on:click="add_btn">add</button>
        </div>
      </div>
      <div class="col-md-2"></div>
    </div>
    <br>
    <br>
    <div class="row">
      <div class="col-md-2"></div>
      <div class="col-md-8">
        <table class="table table-bordered table-responsive">
          <thead>
            <tr class="success">
              <th class="col-md-2">Product ID</th>
              <th class="col-md-2">Product Name</th>
              <th class="col-md-2">Qty</th>
              <th class="col-md-2"></th>
            </tr>
          </thead>
          <tbody id="pTable">
            <tr v-for="(tRow, k) in table_data" :key="k">
              <td>
                <input readonly class="form-control" type="text" v-model="tRow.id">
              </td>
              <td>
                <input readonly class="form-control" type="text" v-model="tRow.name">
              </td>
              <td>
                <input
                  class="form-control"
                  type="number"
                  min="0"
                  step="1"
                  required
                  @change="calculate"
                  v-model="tRow.qty"
                >
              </td>
              <td scope="row" class="trashIconContainer">
                <i class="far fa-trash-alt" @click="deleteRow(k, tRow)">
                  <button type="button" class="btn btn-danger">Delete</button>
                </i>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="col-md-2"></div>
    </div>
    <br>
    <br>
    <div class="row" id="calc">
      <div class="col-md-2"></div>
      <div class="col-md-2">
        <button type="button" class="btn btn-success" v-on:click="calculate">Calculator</button>
      </div>
      <div class="col-md-2"></div>
      <div class="col-md-1">
        <h4>Total :</h4>
      </div>
      <div class="col-md-2">
        <h4>
          <b>{{Total}}</b>
        </h4>
      </div>
      <div class="col-md-1">
        <h4>Rs.</h4>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "PriceList",
  data() {
    return {
      productTypes: [],
      product_name: null,
      selectedType: null,
      products: [],
      prodQty: 0,
      prodName: null,
      Total: null,
      table_data: [
        {
          id: 1,
          name: "Sohan",
          qty: 20
        }
      ]
    };
  },
  mounted() {
    this.getProducts();
    console.log("mounted: got here");
    this.table_data.splice(0, 1);
  },

  methods: {
    getProductName() {
      const self = this;
      const url = "http://localhost:8080/products/id/" + this.selectedType;
      axios
        .get(url)
        .then(response => {
          console.log(url);
          this.product_name = response.data;
        })
        .catch(error => {
          console.log(error);
          return "error";
        });
    },
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
    },
    calculate() {
      if (this.table_data.length > 0) {
        var self = this;
        console.log(this.table_data);
        axios({
          method: "post",
          url: "http://localhost:8080/cal/",
          data: this.table_data
        })
          .then(function(response) {
            console.log(JSON.stringify(response.data));
            self.Total = response.data;
          })
          .catch(function(error) {
            console.log(error);
          });
      } else {
        this.Total = 0.0;
      }
    },
    add_btn() {
      if (this.prodQty > 0 && this.selectedType > 0) {
        if (this.productTypes.includes(this.selectedType)) {
          alert("This product already added to the table");
        } else {
          this.productTypes.push(this.selectedType);
          this.table_data.push({
            id: this.selectedType,
            name: this.product_name,
            qty: this.prodQty
          });
          console.log(this.table_data);
        }
      } else {
        alert("Product ID and Qty can not be empty");
      }
      this.calculate();
    },
    deleteRow(index, test) {
      let idx = this.table_data.indexOf(test);
      console.log(idx, index);
      if (idx > -1) {
        let i = this.productTypes.indexOf(this.table_data[idx].id);
        this.productTypes.splice(i, 1);
        this.table_data.splice(idx, 1);
      }
      this.calculate();
    }
  }
};
</script>

<style>
</style>
