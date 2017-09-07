function write2()
{	  
//		window.open("write", "newwin", "top=200","left=400","width=400","height=300", "resizable=no");
location.href="write";

}

function return1()
{	  
//		window.open("write", "newwin", "top=200","left=400","width=400","height=300", "resizable=no");
location.href="../";

}


function search()
{ 
  var title=document.getElementById("title"); 	
  if(title.value=="")
  {
	alert("검색어를 입력하세요");   
	return false;  
  }
  return true;
}






function finish()
{
	var title=document.getElementById("title");
	var content=document.getElementById("content");
	
	if(title.value=="")
		{alert("제목을 입력하세요.");
		return false;
		}
	
	if(title.value.length<5 || title.value.length>20)
	{alert("제목은 5자리 이상 20자리 이하로 써주세요 ");
	return false;
	}
	
	if(content.value=="")
	{alert("내용을 입력해주세요");
	return false;
	}
	
	if(title.value.length<5 || title.value.length>500)
	{alert("내용은 5자리 이상 100자리 이하로 써주세요 ");
	return false;
	}
	
	return true;

	  	
}