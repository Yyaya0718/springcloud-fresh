let check_info=new Vue({
	el:"#login",
	data:{
		nickName:""
	},
	mounted:function(){
		axios.get("member/checkinfo",{param:{}}).then(yc=>{
			if(yc.data!=null){
				this.nickName=yc.data.nickName;
			}else{
				this.nickName='';
			}
		})
	}
})
