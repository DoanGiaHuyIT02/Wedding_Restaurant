// ExampleCarouselImage.js
import React from 'react';

const ExampleCarouselImage = ({ text, imageUrl }) => {
  return (
    <div>
      <img src={imageUrl} alt={text} />
      <p>{text}</p>
    </div>
  );
};

export default ExampleCarouselImage;
