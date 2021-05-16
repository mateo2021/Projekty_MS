import React, { Component } from 'react';
import './App.css';

class App extends Component {

  state={
    users:[]
  }

//pobieranie restAPi

  componentDidMount(){
    const xhr = new XMLHttpRequest()

    xhr.open('GET','https://jsonplaceholder.typicode.com/users',true);

    xhr.onload=()=>{
      console.log(xhr.status)

      if(xhr.status===200){
        const users = JSON.parse(xhr.response)
        console.log(users)
        this.setState({
          users: users
        })
      }
    }

    xhr.send(null)
  }  
  render() {

    const items = this.state.users.map(item=>(
      <div key={item.id}>
      <h3>{item.name}</h3>
      <p>{item.address.city}</p>
      </div>
    ))
    return (
        <div>
          {items}
        </div>
    );
  }
}

export default App;
