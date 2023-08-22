import './Menu.css';
import './bootstrap.min.css';
import a from "../../image/heading-banner.jpg"

const Menu = () => {

    const backgroundImageStyle = {
        backgroundImage: `url(${a})`,
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
        position: 'relative'
    };
    return (
        <>
            <div className="container-fluid page-header mb-5 p-0 " style={backgroundImageStyle} >
                <div className="container-fluid page-header-inner py-5">
                    <div className="container text-center pb-5">
                        <h1 className="display-3 mb-3 text-white animated slideInDown ">Thực đơn</h1>
                    </div>
                </div>
            </div>
            <div id="about">
                <div className="container">
                    <div className="section-header">
                        <h2>About Royal Hotel</h2>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in mi libero. Quisque convallis, enim at venenatis tincidunt.
                        </p>
                    </div>
                    <div className="row">
                        <div className="col-md-6 img-cols">
                            <div className="img-col">
                                <img class="img-fluid" src={a} />
                            </div>
                        </div>
                        <div className="col-md-6 content-cols">
                            <div className="content-col">
                                <h3>Lorem ipsum dolor</h3>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla justo justo. Proin sodales bibendum pharetra. Aliquam blandit sapien eu nisl dictum pretium.
                                </p>
                                <p>
                                    Nam fringilla justo justo. Proin sodales bibendum pharetra. Aliquam blandit sapien eu nisl dictum pretium.
                                </p>
                                <a href="#">Learn More</a>
                            </div>
                        </div>
                    </div>
                    <hr />

                    <div class="row">
                        <div class="col-md-6 img-cols d-block d-md-none">
                            <div class="img-col">
                                <img class="img-fluid" src={a} />
                            </div>
                        </div>
                        <div class="col-md-6 content-cols">
                            <div class="content-col">
                                <h3>Lorem ipsum dolor</h3>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla justo justo. Proin sodales bibendum pharetra. Aliquam blandit sapien eu nisl dictum pretium.
                                </p>
                                <p>
                                    Nam fringilla justo justo. Proin sodales bibendum pharetra. Aliquam blandit sapien eu nisl dictum pretium.
                                </p>
                                <a href="#">Learn More</a>
                            </div>
                        </div>
                        <div class="col-md-6 img-cols d-none d-md-block">
                            <div class="img-col">
                                <img class="img-fluid" src={a} />
                            </div>
                        </div>
                    </div>

                    <hr />

                    <div class="row">
                        <div class="col-md-6 img-cols">
                            <div class="img-col">
                                <img class="img-fluid" src={a} />
                            </div>
                        </div>
                        <div class="col-md-6 content-cols">
                            <div class="content-col">
                                <h3>Lorem ipsum dolor</h3>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla justo justo. Proin sodales bibendum pharetra. Aliquam blandit sapien eu nisl dictum pretium.
                                </p>
                                <p>
                                    Nam fringilla justo justo. Proin sodales bibendum pharetra. Aliquam blandit sapien eu nisl dictum pretium.
                                </p>
                                <a href="#">Learn More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Menu;