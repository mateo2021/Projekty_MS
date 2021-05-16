import React from 'react'
import Task from './Task'

const TaskList=(props)=>{


    const activeTasks= props.tasks.filter(task=>task.active)
    const unActiveTasks= props.tasks.filter(task=>!task.active)

    activeTasks.sort((a,b)=>{
        const aa = a.text.toLowerCase()
        const bb = b.text.toLowerCase()
        if(aa>bb){
            return -1
        } if(aa<bb){
            return 1
        }
        return 0       
        
    })
    activeTasks.sort((a,b)=>{
        if(a.finishDate > b.finishDate){
          return 1
        }
        if(a.finishDate < b.finishDate){
         return -1
       }
       return 0
      })

const activeTasksr = activeTasks.map(task=>(
<Task
key={task.id}
id={task.id}
text={task.text}
imp = {task.important}
date={task.date}
finish={task.finishDate}
active={task.active}
deleteTask={props.deleteTask}
addToDoneTask={props.addToDoneTask}
/>))

const unActiveTasksr = unActiveTasks.map(task=>(
    <Task
    key={task.id}
    id={task.id}
    text={task.text}
    date={task.date}
    active={task.active}
    finish={task.finishDate}
    deleteTask={props.deleteTask}
    addToDoneTask={props.addToDoneTask}
    />))

    

    return(
        <>
        <h4>
        Lista zadań do wykonania ( {activeTasks.length} )
        </h4>        

        <div>
            {activeTasks.length <= 0 ? "Wykonałeś wszystkie zadania GRATULACJE !" :activeTasksr}
        </div>
        <hr/>
        <div>
        {unActiveTasks.length >0 ? unActiveTasksr: "Nie wykonano jeszcze zadań" }
        </div>
        </>
    )
}


export default TaskList;