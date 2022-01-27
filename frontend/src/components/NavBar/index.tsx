import { ReactComponent as GitHubIcon } from '../../assets/img/github.svg';
import '../../components/NavBar/style.css';
function NavBar() {
    return (
        <header>
            <nav className='container'> 
                <div className='dsmovie-nav-content'>
                    <h1>DSMovie</h1>
                    <a href="#">
                        <div className='dsmovie-contact-container'>
                            <GitHubIcon/>
                            <p className='dsmovie-contact-link'>/gbrsantos</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default NavBar;