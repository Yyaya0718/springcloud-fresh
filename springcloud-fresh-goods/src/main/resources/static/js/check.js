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
		axios.get("member/checkinfo",{param:{}}).then(yc=>{
			if(yc.data!=null && yc.data!=''){
				this.nickName=yc.data.nickName;
				this.cartNum=yc.data.cartNum;
			}else{
				this.nickName='';
				this.cartNum=0;
			}
		})
	}
})
