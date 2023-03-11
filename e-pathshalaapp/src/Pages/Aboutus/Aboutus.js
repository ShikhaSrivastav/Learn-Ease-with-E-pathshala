import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './Aboutus.css'
import Navibar from "../../Components/Navbar/Navibar";
const Aboutus = () => {
return (

// 	<div>
//         <Navibar/>
// 	<div className="about">
// 	  <div className="aboutus">
          
// 		<div className="box">
            
// 		  <br></br>
// 		<div className="Box-mb3">
// 		  <h1 id="h2" style={{color:'bisque'}}> About us</h1>
// 		  <h2 id="label" style={{color:'bisque'}}>
// 			{/* ,height:700 */}
// 			E-Learning is changing the usual learning experience. It has become the new standard way of learning and is highly beneficial to students due to its flexibility, low cost, and user experience.

// There are a lot of e-learning websites offering free online courses and certifications. After all, websites fill the gap between online learners and educators.

// 		  </h2>
// 		  </div>
// 		</div>
// 	  </div>
// 	</div>
//   </div>

        <>
        
     <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="/"><img src="assets/img/logo.png" alt="E-Pathshala" /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                    <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="/Courses">Courses</a></li>
                        {/* <li class="nav-item"><a class="nav-link" href="/Aboutus">About</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="/team">Team</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="/contact">Contact</a></li> */}
                        <li class="nav-item"><a class="nav-link" href="/signin">Signin</a></li>
                        <li class="nav-item"><a class="nav-link" href="/signup">Signup</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div>
            <p id="hey">
            The Title Project is one of those "What I wish I had when I was learning" resources.
                    Not everyone has access to a computer science education or the funds to attend
                    an intensive coding school and neither of those is right for everyone anyway.
                    This project is designed to fill in the gap for people who are trying to hack
                    it on their own but still want a high quality education.
            </p>
        </div>
            <div id="aboutContainer">
                <h2>About the Company</h2>
                <p id="about">The Title Project is one of those "What I wish I had when I was learning" resources.
                    Not everyone has access to a computer science education or the funds to attend
                    an intensive coding school and neither of those is right for everyone anyway.
                    This project is designed to fill in the gap for people who are trying to hack
                    it on their own but still want a high quality education. </p>


                <h2>Our Beliefs</h2>

                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image1.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Education should be free and accessible </h3>
                        <p>This curriculum itself is free and we tried to link to resources that are
                            themselves free so anyone in the world can use them. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image2.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>You learn best by actually building </h3>
                        <p>The Odin Project curriculum is full of projects that will help you build a
                            strong portfolio of work on GitHub to fill out your resume. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image3.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Motivation is fueled by working with others </h3>
                        <p>We're committed to connecting students together so they can stay motivated
                            and learn faster. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image4.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Open source is best </h3>
                        <p>Our curriculum and website are available on GitHub and we encourage students
                            to actually contribute to the project itself! </p>
                    </div>
                </div>
            </div>
        </>
    );
}


export default Aboutus

