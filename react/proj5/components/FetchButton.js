import React from 'react'


const FetchButton=props=>{
    return(
       <button 
         style={{
           padding:10,
           backgroundColor:'white',
           border:'2px solid black',
           fontSize:17,
           cursor:'pointer'}}
          onClick={props.onClick } 
           >
           
        Dodaj randomową osobę :D
       </button>
    )
}


export default FetchButton
