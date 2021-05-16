import React, { Component } from 'react';
import './App.css';
import FetchButton from './FetchButton'
import ListPersons from './ListPersons'


const API ="https://randomuser.me/api/?results=1"

class App extends Component {

handleFetchButton=()=>{

  fetch(API)
  .then(response=>{
    if(response.ok){
      return response;
    }
    throw Error(response.error)
  })
  .then(response=>response.json())
  .then(data=> {
    const datax = data.results;
    this.setState(prevState=>({
      persons: prevState.persons.concat(datax)
    }))
  })
  .catch(error=>console.log(error))
}



  state={
    persons:[]
  }
  render() {
   // console.log(this.state.persons)
   const persons =this.state.persons
    return (
      
      <>
      <FetchButton
      onClick ={this.handleFetchButton}
      />
      {persons.length ?<ListPersons person={persons}/> : null}
      </>
    );
  }
}

export default App;
