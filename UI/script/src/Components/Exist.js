import React, { Component } from 'react';



class Exist extends Component {



    render() {
        return (
        <div className="layout">
            <h1>Exist Page</h1>
            <div className="Exist">
               <div className="cover">
                    <div className="form-label">
                        <p>First Name:</p>
                    </div>
                    <div className="form-value">
                        <input />
                    </div>
               </div>
               <div className="cover">
                    <div className="form-label">
                        <p>Last Name:</p>
                    </div>
                     <div className="form-value">
                         <input />
                      </div>
                </div>
                <div className="cover">
                    <div className="cover-inner">
                        <button type="submit">Submit</button>
                        <button type="button">Edit</button>
                    </div>
                </div>
         </div>





            </div>
        );
    }
}

export default Exist;