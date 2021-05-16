import React, { Component } from 'react';
import AddTask from './AddTask'
import TaskList from './TaskList'
import './App.css';




class App extends Component {
  counter =4;
  state={
    tasks:[
      {
        id:0,
        text:"Zagrać w jakś grę ",
        date:"2019-02-15",
        important:false,
        active:true,
        finishDate:null,
      },
      {
        id:1,
        text:"Zrobić zakupy ",
        date:"2019-02-25",
        important:true,
        active:true,
        finishDate:null,
      },
      {
        id:2,
        text:"Zrobić tosty ",
        date:"2019-05-25",
        important:false,
        active:true,
        finishDate:null,
      },
      {
        id:3,
        text:"Kupić szampon do mycia samochodu ",
        date:"2013-03-15",
        important:true,
        active:true,
        finishDate:null,
      }
    ]
  }

  addTaskToList=(text,checkbox,date)=>{
    const tasks={
      id:this.counter,
      text,
      date,
      important:checkbox,
      active:true,
      finishDate:null,
    }

    this.setState(prevState=>({
      tasks:[...prevState.tasks,tasks]
    }))
    

    this.counter++;
    return true
  }

  deleteTask=(id)=>{
    
    let tasks = [...this.state.tasks]
    const index = tasks.findIndex(task=>id===task.id)
    tasks.splice(index,1)
    this.setState({
      tasks
    })

  }

  addToDoneTask=(id)=>{
    let tasks = [...this.state.tasks]

    tasks.forEach(task=>{
      if(task.id === id){
        task.active = false
        task.finishDate = new Date().getTime()
      }
    })
    this.setState({
      tasks
    })
  
  }



  render(){
    
    return(
      <div>
        <AddTask adTask={this.addTaskToList}/>
        <hr></hr>
        <TaskList 
        tasks = {this.state.tasks}
        deleteTask={this.deleteTask}
        addToDoneTask={this.addToDoneTask}
        />
      </div>
    )
  }
  }




export default App;
