import React from 'react'


const ListPersons=props=>{

    console.log(props.person)

    const users = props.person.map(user=>(
        <div key={user.login.uuid}>
            <img src={user.picture.large} alt={user.name.first}/>
            <h4>{`Godność: ${user.name.first} ${user.name.last}`}</h4>
            <p>{`E-mail: ${user.email}`}</p>
        </div>
    ))
    return(
        <div className="infoDiv">
            {users}
        </div>
    )
}


export default ListPersons
