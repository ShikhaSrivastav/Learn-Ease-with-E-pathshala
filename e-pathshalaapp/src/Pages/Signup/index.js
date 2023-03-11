import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom'
import { useState } from 'react'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { URL } from '../../config'
import Navibar from '../../Components/Navbar/Navibar';
import './index.css'
import { isDate } from 'moment-timezone';

const Signup = () => {
  const [fName , setFirstName] = useState('')
  const [lName , setLastName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [registrationDate , setRegistrationDate] = useState('')
  const [qualification , setQualification] = useState('')
  const [publishedCourses , setnum_Of_Published_Courses ] = useState('')
  const [contact , setContact ] = useState('')
  const [adharNo , setAdharNo ] = useState('')
  const [role, setRole] = useState('user')


  // used to navigate from one component to another
  const navigate = useNavigate()

  const signupUser = () => {
    if (fName.length == 0) {
      toast.warning('Please enter First Name')
    } else if (lName.length == 0) {
      toast.warning('Please enter Last Name')
    } else if (email.length == 0) {
      toast.warning('Please enter Email')
    } else if (password.length == 0) {
      toast.warning('Please enter Password')
    // } else if (registrationDate.length == 0) {
    //   toast.warning('Please enter your registrationDate')
    } else if (qualification.length == 0) {
      toast.warning('Please enter your Qualification')  
    } else if (publishedCourses.length == 0) {
      toast.warning('Please enter your num_Of_Published_Courses') 
    } else if (contact.length == 0) {
      toast.warning('Please enter your Secret Question') 
    } else if (contact.length > 10) {
      toast.error('You Entering More Than 10 Digits ContactNo')  
    }else if (contact.length < 10) {
      toast.error('You Entering less Than 10 Digits ContactNo')  
    } else if (adharNo.length == 0) {
      toast.warning('Please enter your adharNo')  
    } else if (adharNo.length >10) {
      toast.error('You Entering More Than 10 Digits AdharNo')  
    }else if (adharNo.length < 10) {
      toast.error('You Entering less Than 10 Digits AdharNo')  
    }
    
    //  else if (password != confirmPassword) {
    //   toast.warning('Password does not match')
    //   } 
    else {
      const body = {
        fName,
        lName,
        email,
        password,
        registrationDate,
        qualification,
        publishedCourses,
        contact,
        adharNo,
        role,
      }

      // url to call the api
      const url = `${URL}/user/signup`

      // http method: post
      // body: contains the data to be sent to the API
      axios.post(url, body).then((response) => {
        // get the data from the response
        const result = response.data
        console.log(result)
        if (result['status'] == 'success') {
          toast.success('Successfully signed up new user')

          // navigate to the signin page
          navigate('/signin')
        } else {
          toast.error(result['error'])
        }
      })
    }
  }
  
let today = new Date().toISOString().slice(0, 10)

console.log(today)

  return (
    <div className='signup'>
      
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
                        <li class="nav-item"><a class="nav-link" href="/Aboutus">About</a></li>
                        {/* <li class="nav-item"><a class="nav-link" href="/team">Team</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="/contact">Contact</a></li> */}
                        <li class="nav-item"><a class="nav-link" href="/signin">Signin</a></li>
                        {/* <li class="nav-item"><a class="nav-link" href="/signup">Signup</a></li> */}
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
      <h1>Signup</h1>
      <br></br>
      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                First Name
              </label>
              
              <input
                onChange={(e) => {
                  setFirstName(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Last Name
              </label>
              <input
                onChange={(e) => {
                  setLastName(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Email 
              </label>
              <input
                onChange={(e) => {
                  setEmail(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Password
              </label>
              <input
                onChange={(e) => {
                  setPassword(e.target.value)
                }}
                type="password"
                className="form-control"
              />
            </div>

            <div className="mb-3">
            <label htmlFor="" className="label-control">
                REsgistrationDate
              </label>
              <input
                onChange={(e) => {
                  setRegistrationDate(e.target.value)
                }}
                // type="date"
                className="form-control"
                value={today}
                // readOnly = {true}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
              Qualification
              </label>
              <input
                onChange={(e) => {
                  setQualification(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
              num_Of_Published_Courses
              </label>
              <input
                onChange={(e) => {
                  setnum_Of_Published_Courses(e.target.value)
                }}
                type="number"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
              Contact
              </label>
              <input
                onChange={(e) => {
                  setContact(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
              AdharNo
              </label>
              <input
                onChange={(e) => {
                  setAdharNo(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Role
              </label>
              <input
                onChange={(e) => {
                 setRole(e.target.value)
                }}
                type="text"
                className="form-control"
                
                required = {true} 
                // readOnly = {true}
                value="user"
                
              />
            </div>

            <div className="mb-3">
              <div>
                Already have an account? <Link to="/signin">Signin here.</Link>
              </div>
              <br></br>
              <div>
               for home page  <Link to="/home">click here</Link>
              </div>
              <br></br>
              <button onClick={signupUser} className="btn btn-primary">
                Signup
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  )
}

export default Signup
