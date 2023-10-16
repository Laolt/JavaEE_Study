<!-- 通过localhost:5173访问 -->
<template>
  <div @click="getTrain"></div>
  <h1 v-for="(item,index) in dataList" >{{ item }}</h1>
</template>
<script>
export default{
  data(){
    return{
      msg:"666",
      dataList:[]
    }
  },
  methods(){
    getTrain(){
      axios.get("http://localhost:8080/trains/0").then((res)=>{
        console.log(res.data)
        this.dataList=res.data.data
      });
    }
  }
}
</script>



