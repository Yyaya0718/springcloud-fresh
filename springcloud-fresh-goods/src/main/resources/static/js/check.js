let check_info=new Vue({
	el:"#login",
	data:{
		nickName:'',
		cartNum:0
	},
	mounted:function(){
		axios.get("member/checkinfo",{param:{}}).then(yc=>{
			if(yc.data!=null){
				this.nickName=yc.data.nickName;
				this.cartNum=yc.data.cartNum;
			}else{
				this.nickName='';
				this.cartNum=0;
			}
		})
	}
})
