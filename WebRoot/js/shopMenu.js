/**
 * 定义商品的菜单
 */
   var loadHotData = false;
   var loadDisData = false;
   //打折商品的菜单
   function loadDisType(){
	  if(!loadDisData){
		  $.ajax({
			  cache: true,
			  type: 'POST',
			  url:'/SnackShop/product/selectAllType.action',
			  async:false,
			  success:function(data){
				  $.each(data,function(index,obj){
					  var selectUrl = "<a href='/SnackShop/product/selectByDisType.action?pageNo="+1+"&pdtype="+obj.pttype+"'>"+obj.pttype+"</a>";
					  var types1 = "<li>"+selectUrl+"</li>";
					  if(index < 5){ //只有5个菜单，就显示在第一个界面上
						  $("#dis1").append(types1);
					  }else if(index>6 && index<10){
						  $("#dis2").append(types1);
					  }else{
						  $("#dis3").append(types1);
					  }
					 });
			  }
		  });
		  //已经加载过数据 	
		  loadDisData = true;
	  }
  }
   //正常商品的菜单
  function loadHotType(){
	  if(!loadHotData){
		  $.ajax({
			  cache: true,
			  type: 'POST',
			  url:'/SnackShop/product/selectAllType.action',
			  async:false,
			  success:function(data){
				  $.each(data,function(index,obj){
					  var selectUrl = "<a href='/SnackShop/product/selectByHotType.action?pageNo="+1+"&pdtype="+obj.pttype+"'>"+obj.pttype+"</a>";
					  var types1 = "<li>"+selectUrl+"</li>";
					  if(index < 5){ //只有5个菜单，就显示在第一个界面上
						  $("#hot1").append(types1);
					  }else if(index>6 && index<10){
						  $("#hot2").append(types1);
					  }else{
						  $("#hot3").append(types1);
					  }
					 });
			  }
		  });
		  //已经加载过数据 	
		  loadHotData = true;
	  }
  }
