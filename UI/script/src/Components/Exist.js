import React, { Component } from 'react';



class Exist extends Component {



    render() {
        return (
            <div className="Exist">
               <div className="form-cover">
                    <div className="form-label">
                        <p>First Name:</p>
                    </div>
                    <div className="form-value">
                        <input />
                    </div>
               </div>
               <div className="form-cover">
                    <div className="form-label">
                        <p>Last Name:</p>
                    </div>
                     <div className="form-value">
                         <input />
                      </div>
                </div>
                <div className="form-cover">
                    <div className="form-cover-inner">
                        <button type="submit">Submit</button>
                        <button type="button">Edit</button>
                    </div>
                </div>






            </div>
        );
    }
}

export default Exist;