/**
 * Created by bf50 on 2015/12/22.
 */
$(function() {
    $("#button1").click(function() {
        $.ajax({
            type:"POST", // 提交方式
            url:ctx_global+"/addPets", // 路径
            data:{
                name:"tom",
                desc:"cat"
            }, // 数据，这里使用Json格式进行传输
            success:function(result){//返回数据根据结果进行相应的处理
                console.log(result);
            },
            error:function(){
                console.log("error");
            }
        })
    });
});