import React, { Component } from 'react';
import './App.css';




const data=[
  {
    id:1,
    title:"Tytuł numer 1",
    body:" Treść numer 1 zawiera ###"
  },
  {
    id:2,
    title:"Tytuł numer 2",
    body:" Treść numer 2 zawiera ###"
  }
]

setInterval(()=>{
  console.log("tworzy")
  const index = data.length +1
  data.push({
    id:index,
    title:`Tytuł numer ${index}`,
    body:`Treść numer ${index} zawiera ###`
  })
},10000)

class App extends Component {

  state={
    comments:[...data]
  }

  getData=()=>{
    if(this.state.comments.length !== data.length){
    console.log("setstate")
    this.setState({
      comments:[...data]
    })
  }else{
    console.log("nie ma aktualizacji")
  }
  }

  componentDidMount(){
     this.index= setInterval(this.getData,2000)
  }
  componentWillUnmount(){
    clearInterval(this.index)
  }

  render() {

    console.log(this.state.comments)
      const items = this.state.comments.map(item=>(
        <div key={item.id}>
            <h4>{item.title}</h4>
            <div>{item.body}</div>
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
