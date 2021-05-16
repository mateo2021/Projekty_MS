import React,{Component} from 'react'


const actualDate = new Date().toISOString().slice(0,10)



class AddTask extends Component{

    state={
        text:"",
        checkbox:false,
        date:actualDate,
    }

    handleInput=(e)=>{
        const text = e.target.value
        const name = e.target.name

        if(name==="text" || name ==="date"){        
            this.setState({
            [name]: text
        })       
        }
        if(name === "checkbox"){
            this.setState({
                checkbox: !this.state.checkbox
            })       
        }
    }

    sendTaskToAdd=(props)=>{
        const {text,checkbox,date} = this.state
        if(this.state.text.length >2){
        let add = this.props.adTask(text,checkbox,date)
        
        if(add){
         this.setState({
            text:"",
            checkbox:false,
            date:actualDate,
         })
        }
    }
    else{
        console.alert('podałeś za krótki task')
    }
    }

    
    render(){

        let max = actualDate.slice(0,4)*1+1
        max = max+"-12-31"
        return(  
            <>          
       <h3>
           TDOO APP V2
       </h3>       
       <div>
        <label htmlFor="text">
           <input 
           type="text" 
           name="text" 
           id="text" 
           onChange={this.handleInput} 
           value={this.state.text}/> Wprowadz zadanie do wykonania
       </label>
       <br/>
       <br/>
       <label htmlFor="checkbox">
           <input 
           type="checkbox"
           id="checkbox"
           name="checkbox"
           checked={this.state.checkbox}
           onChange={this.handleInput}
           /> Czy zaznaczyć jako sprawę priorytetową ?
       </label>
       <br/>
       <br/>
       <label htmlFor="date">
           Podaj datę do kiedy chcesz wykonać sprawę <input 
           type="date" 
           name="date" 
           id="date"
           min={actualDate} 
           max={max}
           value={this.state.date}
           onChange={this.handleInput}
           />
       </label>
            <br></br>
            <br/>
            <button onClick= {this.sendTaskToAdd}>
                Dodaj
            </button>
      </div>

       </>
        )
    }
    
   
}

export default AddTask;