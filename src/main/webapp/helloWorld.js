/**
 * Created by bf50 on 2015/12/22.
 */
$(function() {
    $("#button1").click(function() {
        $.ajax({
            type:"POST", // �ύ��ʽ
            url:ctx_global+"/addPets", // ·��
            data:{
                name:"tom",
                desc:"cat"
            }, // ���ݣ�����ʹ��Json��ʽ���д���
            success:function(result){//�������ݸ��ݽ��������Ӧ�Ĵ���
                console.log(result);
            },
            error:function(){
                console.log("error");
            }
        })
    });
});