function add_teacher(){
	$.ajax({
		cache: true,
    	type: "POST",
        url:"../TeaAdd",
        data:$("#frm_AddTeacher").serialize(),
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