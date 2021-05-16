import React from 'react';


const Word=props=>{
    return(
        <li>Słowo <strong>{props.plTranslate}</strong> w tłumaczeniu na angielski
         nazywa się <strong>{props.enTranslate}</strong></li>
    )
}

export default Word