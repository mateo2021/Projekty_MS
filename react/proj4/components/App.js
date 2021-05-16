import React, { Component } from 'react';
import './App.css';
import FetchButton from './FetchButton';
import UsersList from './UsersList';


const API ="https://randomuser.me/api/?results=5";


class App extends Component {

  state={
    person:[]

  }


  fetchButtonHandle=()=>{
    console.log('dziala')

    fetch(API)
    .then(response=>{
         if(response.ok){
           return response;
         }
         throw Error( response.error);
    })
    .then(response =>response.json())
    .then(data=>{
      this.setState({
        person: data.results
      })
    })
    .catch(error=>console.log(error))
  }

  render() {
    console.log(this.state.person)
    const person = this.state.person
    
    return (
     <>
     <FetchButton
     onClick={this.fetchButtonHandle}
     />
     <UsersList 
     person={person}
     />
     </>
    );
  }
}

export default App;
