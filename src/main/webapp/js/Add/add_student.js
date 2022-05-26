function add_student(){
	$.ajax({
		cache: true,
    	type: "POST",
        url:"../StuAdd",
        data:$("#frm_AddStudent").serialize(),
        async: false,
        error: function() {
        	    alert("Connection error");
       		},
       success: function(data) {
				if(data=='0')
					alert("添加失败！");
				else
					alert("添加成功！");
        	}
        });
}