import React, { Component } from 'react';
import './App.css';
import './Word.css'
import Word from './Word.js'

class App extends Component {

state={
  word:[],
  isLoaded:false
}


componentDidMount(){
  setTimeout(this.handleFetch,3000)
}

 handleFetch=()=>{
  fetch('data/word.json')
  .then(response=>response.json())
  .then(result=>{
    this.setState({
      word: result.words,
      isLoaded:true
    })
  })
}

  render() {
      console.log('render')
    const words = this.state.word.map(word=>(
      <Word
      key={word.id}
      enTranslate ={word.en}
      plTranslate={word.pl}
      />
    ))
    return (
      <ul>{this.state.isLoaded ? words :"Ładowanie danych . . . "}</ul>
      );
  }
}

export default App;
