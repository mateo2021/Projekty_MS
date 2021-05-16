import React from 'react'



const style={
    color:"red"
}
const Task=(props)=>{

    const {text,date,id,deleteTask,addToDoneTask,active,finish,imp} = props

    

    if(active){
        return(
            <div>
                <p> <strong style={imp?style:null}>{text}</strong> - należy wykonać do - <strong><em>{date}</em>
                </strong> <button onClick={()=>addToDoneTask(id)}>Dodaj do wykonanych</button> <button onClick={()=>deleteTask(id)}>X</button></p>  
            </div>
            )
    }else{

      let finishx = new Date(finish).toISOString().slice(0,10)
        return(
            <p> <strong>{text}</strong> - wykonano- <strong><em>[ {finishx} ]</em>
            </strong> <button onClick={()=>deleteTask(id)}>X</button></p>     
        )
    }

    
}

export default Task;