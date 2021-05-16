

const setClick=()=>{

    const color = getColor(event)
    document.body.style.backgroundColor=color;


   //if(x%2==0 && y%2==0){
    // document.body.style.backgroundColor="red";
  // }else if(x%2!=0 && y%2!=0){
  //  document.body.style.backgroundColor="blue";
  // }else if(x%2==0 && y%2!=0 || y%2==0 && x%2!=0){
  //  document.body.style.backgroundColor="green"; 
  // }

}

const getColor=(e)=>{

    let x = e.clientX;
    let y = e.clientY;
    console.log(x+" " +y);

    if(x%2==0 && y%2==0){
       return "red"; 
    }else if(x%2!=0 && y%2!=0){
        return "blue";
    }else if(x%2==0 && y%2!=0 || y%2==0 && x%2!=0){
        return "green";
    }
}

window.addEventListener("click",setClick)