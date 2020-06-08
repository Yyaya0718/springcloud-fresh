let check_info=new Vue({
	el:"#login",
	data:{
		nickName:'',
		cartNum:0
	},
	methods:{
		checkCart:function(){
			 if($("#name").html()==undefined){
					alert("请先登录...");
					location.href="/user/login.html";
				}else{
					location.href="cart.html";
				}
		 }
	},
	mounted:function(){
		axios.get("/goods/member/checkinfo",{param:{}}).then(yc=>{
			if(yc.data.nickName==null || yc.data.nickName==''){
				this.nickName='';
				this.cartNum=0;
				alert("请先登录...");
				location.href="/user/login.html";
			}else{
				this.nickName=yc.data.nickName;
				this.cartNum=yc.data.cartNum;
			}
		})
	}
})
