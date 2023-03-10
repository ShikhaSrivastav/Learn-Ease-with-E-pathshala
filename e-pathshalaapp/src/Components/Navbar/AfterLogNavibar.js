import React from 'react'
import { Container, Navbar, Nav, NavDropdown, Form, FormControl, Button } from 'react-bootstrap'
import './navbar.css'
import { useNavigate } from 'react-router'
import { useState } from 'react'
import { toast } from 'react-toastify'

const AfterLogNavibar = () => {


  const navigate = useNavigate()
  const [show, setShow]= useState(true)

  let loginRegister

  const { firstName, loginStatus } = sessionStorage

  if (firstName != undefined) {
    loginRegister = `Hello, ${firstName}`
  } else {
    loginRegister = "Login"
  }

  const logoutUser = () => {
    // remove the logged users details from session storage

    if (firstName == undefined) {
      toast.warning("please login first")
    }

    sessionStorage.removeItem("id")
    sessionStorage.removeItem("firstName")
    sessionStorage.removeItem("lastName")
    sessionStorage.removeItem("loginStatus")

    // navigate to sign in component
    navigate("/home")
  }




  return (
<div >
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="/"><img src="assets/img/logo.png" alt="E-Pathshala" /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/Courses">Courses</a></li>
                        {/* <li class="nav-item"><a class="nav-link" href="/portfolio">Portfolio</a></li> */}
                        <li class="nav-item"><a class="nav-link" href="/Aboutus">About</a></li>
                        {/* <li class="nav-item"><a class="nav-link" href="#team">Team</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="/signin">Signin</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="/signup">Signup</a></li> */}
                        <li class="nav-item"><a class="nav-link" href="/Feedback">FeedBack</a></li>
                        <li class="nav-item"><a class="nav-link" href="/Profile">Profile</a></li>
                        <li class="nav-item"><a class="nav-link" onClick={logoutUser}>Logout</a></li>

                       {/* <li> <button class="nav-item" onClick={logoutUser}>Logout</button></li> */}
                    </ul>
                </div>
            </div>
        </nav>
{/* <Navbar className='Main-Nav'>
  <Container fluid>
    <Navbar.Brand className='Brand' style={{color:"black"}} href="#">E-LEARNING</Navbar.Brand>
    <Navbar.Toggle aria-controls="navbarScroll" />
    <Navbar.Collapse id="navbarScroll">
      <Nav
        className="me-auto my-2 my-lg-0"
        style={{ maxHeight: '100px' }}
        navbarScroll
      >
        <Nav.Link href="/Home">Home</Nav.Link>
        <Nav.Link href="/Aboutus">Aboutus</Nav.Link> */} 
        {/* <NavDropdown title="Link" id="navbarScrollingDropdown">
          <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
          <NavDropdown.Item href="#action4">Another action</NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="#action5">
            Something else here
          </NavDropdown.Item>
        </NavDropdown>
        <Nav.Link href="/UserCourses" >
          Courses
        </Nav.Link>
      </Nav>


      <Nav.Link style={{color:"black"}} href="/Feedback">Feedback</Nav.Link>
      <Nav.Link style={{color:"black"}} href="/Profile">Profile</Nav.Link> 
      
      <button onClick={logoutUser}>Logout</button>
    

      {/* <Form className="d-flex">
        <FormControl
          type="search"
          placeholder="Search"
          className="me-2"
          aria-label="Search"
        />
        <Button variant="outline-success">Search</Button>
      </Form> */}
    {/* </Navbar.Collapse>
  </Container>
</Navbar> */}
</div>
  )
}

export default AfterLogNavibar