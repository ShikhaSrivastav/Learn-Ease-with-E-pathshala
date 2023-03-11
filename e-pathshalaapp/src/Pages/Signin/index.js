import Image from 'react-bootstrap/Image';
// import image from 'D:/SigninSigupFormats/SigninSigupFormat/my-app/src/Pages/images/eler.jpg';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react'
import { Link } from 'react-router-dom'
import './index.css'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { URL } from '../../config'
import './index.css'
import Navibar from '../../Components/Navbar/Navibar';

const Signin = () => {
  const [user_id, setUserId] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const[role, setRole]= useState('')

  const navigate = useNavigate()

  const signinUser = () => {
    if (email.length == 0) {
      toast.warning('please enter your Email')
    } else if (password.length == 0) {
      toast.warning('please enter your Password')
    } else {
      const body = {
        email,
        password,
        role,
      }

      // url to make signin api call
      const url = `${URL}/user/signin`

      // make api call using axios
      axios.post(url, body).then((response) => {
        // get the server result
        const result = response.data
        console.log(result)
        if (result['status'] == 'success') {
          toast.success('Welcome to the application')

          // get the data sent by server
          const { user_id, fName, lName, role } = result['data']

          // persist the logged in user's information for future use
          sessionStorage['id'] = user_id
          sessionStorage['fName'] = fName
          sessionStorage['lName'] = lName
          sessionStorage['loginStatus'] = 1
          
          
          // navigate to home component
          if(role === 'user'){
            console.log('usercourses')
            navigate('/usercourses')
          }else if(role === 'admin'){
            navigate('/admin')
          }

        } else {
          toast.error('Invalid user name or password')
        }
      })
    }
  }

  return (

   
    
    <div  class="signin">
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
                        {/* <li class="nav-item"><a class="nav-link" href="#team">Team</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li> */}
                        {/* <li class="nav-item"><a class="nav-link" href="/signin">Signin</a></li> */}
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
        <div id='mydiv'>
      <h1>Signin</h1>
      <br></br>
     
      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form shadow">
          <div id='box'> 
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Email address
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
              <div>
                No account yet? <Link to="/signup">Signup here</Link>
              </div>
              <br></br>
              <div>
                forgot password? <Link to="/secretquestion">Answer Your Secret Question here</Link>
              </div>
              <br></br>
              <div>
               for home page  <Link to="/home">click here</Link>
              </div>
              <br></br>
              <button onClick={signinUser} className="btn btn-primary">
                Signin
              </button>
            </div>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>


</div>
    </div>
  )
}

export default Signin
