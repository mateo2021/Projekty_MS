import React, { Component } from 'react';
import './App.css';

class App extends Component {

state={
  name:"",
  email:"",
  pass:"",
  checkbox:false,
  message:false,

  errors:{
    name:false,
    email:false,
    pass:false,
    checkbox:false, 
    sumAll:false
  }
}

validateMessages={
  incorectLogin:"Niepoprawna długośc nazwy uzytkownika",
  incorectEmail:"Niepoprawny mail",
  incorectPass:"Zbyt krótkie hasło",
  incorectCheckbox:"Zaakceptuj regulamin"
}

handleValueChange=(e)=>{

  const value = e.target.value;
  const name = e.target.name;

 if(name === "name" || name === "email" || name === "pass"){
  this.setState({
    [name]:value
  })
} else if(name === "checkbox"){

  const checked = e.target.checked
  this.setState({
    [name]:checked
  })
  }
}




handleSubmit=(e)=>{
e.preventDefault()

const validate = this.handleValidate()

console.log(validate)

if(validate.sumAll){
  this.setState({
      name:"",
      email:"",
      pass:"",
      checkbox:false, 
      message:true,   
      errors:{
        name:false,
        email:false,
        pass:false,
        checkbox:false, 
      }
    
  })
}else{
  this.setState({
    errors:{
      name:!validate.name,
      email:!validate.email,
      pass:!validate.pass,
      checkbox:!validate.checkbox, 
    }
  })
}
}


handleValidate=()=>{

 let name = false;
  let email = false;
  let pass= false;
  let checkbox = false;
  let sumAll = false;

console.log('d')

if(this.state.name.length >= 8 && this.state.name.indexOf(' ' === -1)){
  name = true
}
if(this.state.email.indexOf('@') !==-1){
  email=true
}
if(this.state.pass.length >= 8){
  pass=true
}
if(this.state.checkbox){
  checkbox =true
}
if(name&&email&&pass&&checkbox){
  sumAll=true
}

return({
name,
email,
sumAll,
pass,
checkbox
})
}

componentDidUpdate(){
  if(this.state.message){
    setTimeout(()=>this.setState({message:false}),3000)
  }
}






  render() {
    console.log("ds")
    return (
    <form onSubmit={this.handleSubmit} noValidate>

        <label htmlFor="name"> Podaj imie użytkownika:
          <input type="text"  id="name" name="name" value={this.state.name}
          onChange={this.handleValueChange}/>
          {this.state.errors.name && <span> {this.validateMessages.incorectLogin}</span>}
        </label>

        <label htmlFor="email"> Podaj email użytkownika:
          <input type="email" id="email" name="email" value={this.state.email}
          onChange={this.handleValueChange}/>
           {this.state.errors.email && <span> {this.validateMessages.incorectEmail}</span>}
        </label>

        <label htmlFor="pass"> Podaj hasło użytkownika:
          <input type="password" id="pass" name="pass" value={this.state.pass}
          onChange={this.handleValueChange}/>
           {this.state.errors.pass && <span> {this.validateMessages.incorectPass}</span>}
        </label>


        <label htmlFor="checkbox"> Zaakceptuj regulamin:
          <input type="checkbox" id="checkbox" name="checkbox" checked={this.state.checkbox}
          onChange={this.handleValueChange}/>
          {this.state.errors.checkbox && <span> {this.validateMessages.incorectCheckbox}</span>}
        </label>
        

      


        <button>Wyślij zgłoszenie :D</button>


        {this.state.message && <h3>{"Wysłano formularz"}</h3>}

    </form>
    
    
    
    
    
      );
  }
}

export default App;
