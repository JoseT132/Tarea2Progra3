
import java.util.*;
import java.io.*;
import java.sql.*;


public class FabricaSilla {

    public static void main(String[] args) {
    
    try {
        Connection connection = ConexionMariaDB.getConnection();
        if (connection != null) {
        System.out.println("Conexion exitosa con MariaDB");
        connection.close();
        } else {
        System.out.println("Error al conectar con MariaDB");
            }
        } catch (SQLException e) {
          System.out.println("Error: " + e.getMessage());
        }
        
        //Menu de funcionalidades
        Scanner dato= new Scanner (System.in);
        int opcion;
        do {
        System.out.println("\nBienvenido a la carpinteria");
        System.out.println("Seleccione la operación que desea realizar");
        System.out.println("1. Sobre la carpinteria");
        System.out.println("2.Inventario de Materiales");
        System.out.println("3..Elaborar una silla");
        System.out.println("4..Mostrar inventario de Sillas");
        System.out.println("5..Actualizar el estado de fabricación");
        System.out.println("6..Facturar");
        System.out.println("7..Salir del programa");
        opcion=dato.nextInt();
    
        switch(opcion){
            case 1:
                infocarpinteria ();
            break;
            case 2:
                inventarioMat();
             break;
            case 3:
                 ensamblarS();
            break;
            case 4:
                mostrarInventario();
             break;
            case 5:
               actualizarSilla (); 
            case 6:   
               Facturar();
             break;
            case 7:
              break;
            default:
                System.out.println("Opcion no valida");
                
        }
      }while(opcion !=6);         
                
    }
    
    public static void infocarpinteria () {
    System.out.println("Carpinteria tablon");
    System.out.println("Fundada en 1995");
    System.out.println("6a Calle , Cdad. de Guatemala");
  } 
    
    public static void inventarioMat(){
     Scanner dato= new Scanner (System.in);
     
     //Variables a modificar 
    double lbClavos = 0;
    double piesMadera = 0;
    int mlBarniz = 0;
    int mlPegamento = 0;
   
     // Declaración e inicialización de materiales
     System.out.println("Ingrese la cantidad de materiales en inventario");
     System.out.println("Ingrese Lb de clavos");
     lbClavos = dato.nextDouble();
     System.out.println("Ingrese Pies de madera");
     piesMadera = dato.nextDouble();
     System.out.println("Ingrese ML de barniz");
     mlBarniz = dato.nextInt();
     System.out.println("Ingrese ML de pegamento");
     mlPegamento = dato.nextInt();
     
     try (Connection connection = ConexionMariaDB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO inventariomat (Lb_Clavos, Pies_Madera, Ml_Barniz,Ml_Pegamento) "
                        + "VALUES (?, ?, ?, ?)")) {

            preparedStatement.setDouble(1, lbClavos);
            preparedStatement.setDouble(2, piesMadera);
            preparedStatement.setInt(3, mlBarniz);
            preparedStatement.setInt(4, mlPegamento);

           
            preparedStatement.executeUpdate();

         
        } catch (SQLException e) {
            System.out.println("Error al agregar el inventario: " + e.getMessage());
         }
       
    }
    
     public static void ensamblarS() {
        Scanner dato = new Scanner(System.in);
        ArrayList<Silla> sillas = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el tipo de madera (Pino, Cedro, Conacaste)");
            String material = dato.nextLine();
            System.out.println("Ingrese la cantidad de sillas de este material");
            int cantidad = Integer.parseInt(dato.nextLine());
            String estado = "Ensamblado";

            Silla silla = new Silla(material, cantidad, estado);
            sillas.add(silla);

            System.out.println("¿Desea crear otra silla? (S/N)");
            String opcion = dato.nextLine();

            if (!opcion.equalsIgnoreCase("S")) {
                continuar = false;
            }
        }

        for (Silla silla : sillas) {
            System.out.println("Se han creado " + silla.getCantidadS() + " sillas de " + silla.getMaterial());
            InventarioSilla(silla);
            actualizarInventarioMateriales(silla);
            calculaC(silla);
        }
    }
    
     public static void InventarioSilla(Silla silla){
         try (Connection connection = ConexionMariaDB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO inventario (Material, Cantidad, Estado) VALUES (?, ?, ?)")) {

            
            preparedStatement.setString(1, silla.getMaterial());
            preparedStatement.setInt(2, silla.getCantidadS());
            preparedStatement.setString(3, silla.getEstado());

           
            preparedStatement.executeUpdate();

         
        } catch (SQLException e) {
            System.out.println("Error al agregar el inventario: " + e.getMessage());
        }
    }
   

    public static void actualizarInventarioMateriales(Silla silla) {
        try (Connection connection = ConexionMariaDB.getConnection()) {
            // Obtener los valores actuales del inventario de materiales
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT Lb_Clavos, Pies_Madera, Ml_Barniz, Ml_Pegamento FROM inventariomat");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double lbClavosActuales = resultSet.getDouble("Lb_Clavos");
                double piesMaderaActuales = resultSet.getDouble("Pies_Madera");
                int mlBarnizActuales = resultSet.getInt("Ml_Barniz");
                int mlPegamentoActuales = resultSet.getInt("Ml_Pegamento");

                // Calcula los nuevos valores
                Materiales material = new Materiales(0.017, 0.45, 95, 150);
                double lb_clavos = material.getLb_clavos() * silla.getCantidadS();
                double pies_Madera = material.getPies_Madera() * silla.getCantidadS();
                int ml_barniz = material.getMl_barniz() * silla.getCantidadS();
                int ml_pegamento = material.getMl_pegamento() * silla.getCantidadS();

                lbClavosActuales -= lb_clavos;
                piesMaderaActuales -= pies_Madera;
                mlBarnizActuales -= ml_barniz;
                mlPegamentoActuales -= ml_pegamento;

                // Actualiza el inventariomat con los nuevos valores
                PreparedStatement updateStatement = connection.prepareStatement(
                    "UPDATE inventariomat SET Lb_Clavos = ?, Pies_Madera = ?, Ml_Barniz = ?, Ml_Pegamento = ?");

                updateStatement.setDouble(1, lbClavosActuales);
                updateStatement.setDouble(2, piesMaderaActuales);
                updateStatement.setInt(3, mlBarnizActuales);
                updateStatement.setInt(4, mlPegamentoActuales);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Inventario de materiales actualizado exitosamente.");
                } else {
                    System.out.println("No se ha podido actualizar el inventariomat.");
                }
            } else {
                System.out.println("No se encontraron registros en inventariomat.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el inventariomat: " + e.getMessage());
        }
    }
     
    public static void actualizarSilla() {
    Scanner dato = new Scanner(System.in);
    System.out.println("Ingrese el codigo de las sillas a modificar");
    int cod = dato.nextInt();
    
    dato.nextLine(); 
    
    System.out.println("Ingrese el nuevo estado de fabricación (barnizado, tapizado, terminado)");
    String nEstado = dato.nextLine();

    try (Connection connection = ConexionMariaDB.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE inventario SET Estado = ? WHERE Codigo = ?")) {
        
        preparedStatement.setString(1, nEstado);
        preparedStatement.setInt(2, cod);

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Estado del pedido " + cod + " actualizado a: " + nEstado + " exitosamente.");
        } else {
            System.out.println("No se ha encontrado la silla con el Codigo" + cod);
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar el estado: " + e.getMessage());
    }
  }
     public static void mostrarInventario(){
     try (Connection connection = ConexionMariaDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM inventario");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int cod = resultSet.getInt("Codigo");
                String material = resultSet.getString("Material");
                int cantidad = resultSet.getInt("Cantidad");
                String estado = resultSet.getString("Estado");

               System.out.println("Código: " + cod + ", Material: " + material + ", Cantidad: " + 
                       cantidad + ", Estado: " + estado);
             
               
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el inventario " + e.getMessage());
        }
     }
        
     
  public static void calculaC(Silla silla) {
    float precioS = 40; // Precio por silla
    float precioT = 0;

    try (Connection connection = ConexionMariaDB.getConnection()) {
        // Obtener la cantidad de sillas del Inventario
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT Material, Cantidad FROM inventario");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String mat = resultSet.getString("Material");
            int can = resultSet.getInt("Cantidad");

            // Calcular el costo total por silla
            float costoPorSilla = precioS + (0.16f * precioS); // Precio más el 16% de ganancias

            // Calcular el costo total para el material actual
            float costoTotalMaterial = costoPorSilla * can;

            // Agregar el costo del material actual al costo total
            precioT += costoTotalMaterial;

            // Agregar los datos a la tabla factura
            PreparedStatement updateStatement = connection.prepareStatement(
                "INSERT INTO factura (Cantidad, Material, PrecioSilla, TotalF) VALUES (?, ?, ?, ?)");
            updateStatement.setInt(1, can);
            updateStatement.setString(2, mat);
            updateStatement.setFloat(3, costoPorSilla);
            updateStatement.setFloat(4, costoTotalMaterial);

            updateStatement.executeUpdate();
        }

        System.out.println("Costo total de la factura: " + precioT);
    } catch (SQLException e) {
        System.out.println("Error al calcular el costo de la factura: " + e.getMessage());
    }
}

     
   public static void Facturar() {
    Scanner dato = new Scanner(System.in);
    System.out.println("Ingrese el código de las sillas a facturar");
    int cod = dato.nextInt();
    String nEstado = "Vendido";

    try (Connection connection = ConexionMariaDB.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE inventario SET Estado = ? WHERE Codigo = ?")) {
        
        preparedStatement.setString(1, nEstado);
        preparedStatement.setInt(2, cod);

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("El código de silla " + cod + " ha sido marcado como: " + nEstado + " exitosamente.");
        } else {
            System.out.println("Error al realizar la venta de la silla con código " + cod);
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar el estado: " + e.getMessage());
    }
   }
 }



    

