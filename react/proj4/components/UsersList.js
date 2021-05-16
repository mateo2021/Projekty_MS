import React from 'react';


const UsersList=(props)=>{

const users = props.person.map(user=>(
    <div key={user.login.uuid}>
        <h4>{`Godność: ${user.name.first} ${user.name.last}`}</h4>
        <p>{`E-mail: ${user.email}`}</p>
    </div>
))

    return(
     
      <ul>
          {users}
      </ul>
    )
}


export default UsersList;