import React, {useEffect, useState} from 'react';
import {SERVER_URL} from '../constants';
import {DataGrid, gridClasses, GridToolbarContainer, GridToolbarExport} from '@mui/x-data-grid';
import Snackbar from '@mui/material/Snackbar';
import Stack from '@mui/material/Stack';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';

import CarAdd from './CarAdd';
import CarEdit from './CarEdit';
import {CarPayload} from '../models/Car';

export default function CarList() {
  const [cars, setCars] = useState([]);
  const [open, setOpen] = useState(false);

  useEffect(() => {
    fetchCars();
  }, []);

  const fetchCars = () => {
    fetch(`${SERVER_URL}/cars`)
      .then((response) => response.json())
      .then((data) => setCars(data._embedded.cars))
      .catch((err) => console.error(err));
  };

  const onDelClick = (url: string) => {
    if (window.confirm('Are you sure to delete?')) {
      fetch(url, {method: 'DELETE'})
        .then((response) => {
          if (response.ok) {
            fetchCars();
            setOpen(true);
          } else {
            alert('Something went wrong!');
          }
        })
        .catch((err) => console.error(err));
    }
  };

  const addCar = (car: CarPayload) => {
    fetch(`${SERVER_URL}/cars`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(car),
    })
      .then((response) => {
        if (response.ok) {
          fetchCars();
        } else {
          alert('Something went wrong!');
        }
      })
      .catch((err) => console.error(err));
  };

  const updateCar = (car: CarPayload, link: string) => {
    fetch(link, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(car),
    })
      .then((response) => {
        if (response.ok) {
          fetchCars();
        } else {
          alert('Something went wrong!');
        }
      })
      .catch((err) => console.error(err));
  };

  const columns = [
    {field: 'brand', headerName: 'Brand', width: 200},
    {field: 'model', headerName: 'Model', width: 200},
    {field: 'color', headerName: 'Color', width: 200},
    {field: 'year', headerName: 'Year', width: 150},
    {field: 'price', headerName: 'Price', width: 150},
    {
      field: '_links.car.href',
      headerName: '',
      sortable: false,
      filterable: false,
      renderCell: (row: any) => <CarEdit data={row} updateCar={updateCar} />,
    },
    {
      field: '_links.self.href',
      headerName: '',
      sortable: false,
      filterable: false,
      renderCell: (row: any) => (
        <IconButton onClick={() => onDelClick(row.id)}>
          <DeleteIcon color="error" />
        </IconButton>
      ),
    },
  ];

  return (
    <>
      <Stack mt={2} mb={2}>
        <CarAdd addCar={addCar} />
      </Stack>
      <div style={{height: 500, padding: '2rem'}}>
        <DataGrid
          rows={cars}
          columns={columns}
          disableSelectionOnClick={true}
          getRowId={(row: any) => row._links.self.href}
          components={{
            Toolbar: CustomToolbar,
          }}
        />
        <Snackbar open={open} autoHideDuration={2000} onClose={() => setOpen(false)} message="Car deleted" />
      </div>
    </>
  );
}

function CustomToolbar() {
  return (
    <GridToolbarContainer className={gridClasses.toolbarContainer}>
      <GridToolbarExport />
    </GridToolbarContainer>
  );
}
